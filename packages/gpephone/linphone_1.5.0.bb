
DESCRIPTION = "SIP-based IP phone"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPL-2"
DEPENDS = "libosip2 speex libogg alsa-lib readline"
PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/1.5.x/source/linphone-${PV}.tar.gz \
           file://linphone-1.5.0.patch;patch=1 \
           file://linphone-pkgconfig.patch;patch=1;pnum=0"

FILES_${PN} += "${datadir}/linphonec"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gnome_ui --disable-gtk-doc --without-ffmpeg \
                --without-sdl --disable-video --enable-alsa \
                --with-osip=${STAGING_DIR}/${HOST_SYS} \
                --with-readline=${STAGING_DIR}/${HOST_SYS} \
                --disable-truespeech --disable-manual \
                --disable-glibtest --disable-glib"

do_configure () {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
	oe_runconf SPEEX_LIBS="-lspeex" SPEEX_CFLAGS=" "
}

do_compile () {
	oe_runmake "LIBTOOL=${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool" LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
}

do_install () {
	oe_runmake install "DESTDIR=${D}" "LIBTOOL=${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
}

do_install_append() {
	rm -f ${D}${datadir}/sounds/linphone/hello*.wav
	rm -f ${D}${datadir}/sounds/linphone/rings/oldphone.wav
}

do_stage() {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
	autotools_stage_all
	cp ${S}/mediastreamer2/src/libquickstream.la ${STAGING_LIBDIR}
	cp ${S}/mediastreamer2/src/libmediastreamer.la ${STAGING_LIBDIR}
	cp ${S}/coreapi/liblinphone.la ${STAGING_LIBDIR}
}