DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPL-2"
DEPENDS = "gtk+ cairo libxml2 libmad libsdl-mixer zlib boost jpeg pango curl freetype"
PR = "r1"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gnash/${PV}/gnash-${PV}.tar.bz2 \
          "

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=cairo \
                --enable-media=none \
                --disable-klash \
                --enable-z \
                --enable-jpeg \
                --disable-glext \
                --enable-Xft \
                --enable-expat \
                --enable-mad \
                --enable-cairo \
                --disable-plugin \
                --disable-cygnal \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                "

PACKAGES =+ " libgnashamf libgnashbackend libgnashbase libgnashgeo libgnashgui libgnashplayer libgnashserver "

FILES_libgnashamf = "${libdir}/libgnashamf-${PV}.so"
FILES_libgnashbackend = "${libdir}/libgnashbackend-${PV}.so"
FILES_libgnashbase = "${libdir}/libgnashbase-${PV}.so"
FILES_libgnashgeo = "${libdir}/libgnashgeo-${PV}.so"
FILES_libgnashgui = "${libdir}/libgnashgui-${PV}.so"
FILES_libgnashplayer = "${libdir}/libgnashplayer-${PV}.so"
FILES_libgnashserver = "${libdir}/libgnashserver-${PV}.so"

PARALLEL_MAKE = ""