DESCRIPTION = "E17 - the Enlightenment Window Mananger"
DEPENDS = "eet evas ecore edje efreet"
LICENSE = "MIT BSD"
PV = "0.16.999.041+cvs${SRCDATE}"
PR = "r0"

inherit e update-alternatives

SRC_URI = "${E_CVS};module=e17/apps/e \
           file://Xsession.d/98enlightenment \
           file://applications.menu \
           file://Makefile.in.in \
"
S = "${WORKDIR}/e"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/Makefile.in.in po/
	echo "install -d $*" >./mkinstalldirs
	chmod a+rx ./mkinstalldirs
}

do_stage() {
    autotools_stage_all
    for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.la" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.a" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.la" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.a" -print`; do rm -f $I; done
}

do_install_append() {
    # customising - should rather make this simple upstream
    install -d ${D}/${sysconfdir}/X11/Xsession.d
    install -m 755 ${WORKDIR}/Xsession.d/98enlightenment ${D}/${sysconfdir}/X11/Xsession.d
    install -d ${D}/${sysconfdir}/xdg/menus
    install -m 644 ${WORKDIR}/applications.menu ${D}/${sysconfdir}/xdg/menus/
}

FILES_${PN} = "\
  ${bindir}/* \
  ${libdir}/enlightenment/modules/*/*.* \
  ${libdir}/enlightenment/modules/*/*/* \
  ${libdir}/enlightenment/preload/*.so \
  ${datadir} \
  ${sysconfdir} \
"
FILES_${PN}-dbg += "\
  ${libdir}/enlightenment/modules/*/*/.debug/ \
  ${libdir}/enlightenment/preload/.debug/ \
"

ALTERNATIVE_PATH = "${bindir}/enlightenment_start"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"