require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib libfsoresource android-rpc i2c-tools"
RPROVIDES_${PN} = "openmoko-alsa-scenarios virtual/alsa-scenarios"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.4+gitr${SRCPV}"
PE = "2"
PR = "${INC_PR}.19"

EXTRA_OECONF = "\
  --enable-kernel26-rfkill \
  --disable-player-canberra \
  --enable-htcdream-powercontrol \
"

inherit update-rc.d

INITSCRIPT_NAME = "fsodeviced"
INITSCRIPT_PARAMS = "defaults 27"

SRC_URI += "file://fsodeviced"

do_configure_prepend() {
	install ${STAGING_INCDIR}/linux/i2c-dev-user.h ${STAGING_INCDIR}/linux/i2c-dev.h
}

CONFFILES_${PN} = "${sysconfdir}/freesmartphone/conf/openmoko_gta/fsodeviced.conf \
                   ${sysconfdir}/freesmartphone/conf/palm_pre/fsodeviced.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_dream/fsodeviced.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_msm/fsodeviced.conf \
                  "

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/fsodeviced ${D}${sysconfdir}/init.d/
}

pkg_preinst_${PN} () {
	# work-arround for opkg complaining that it cannot replace alsa-default dir (leftover from older fsodeviced) with new alsa-default symlink
        rm -rf ${sysconfdir}/freesmartphone/conf/openmoko_gta/alsa-default/
}
