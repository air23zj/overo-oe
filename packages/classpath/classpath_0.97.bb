require classpath.inc

SRC_URI += "\
  file://xmlstream-fix.patch;patch=1;pnum=0 \
  "

PR = "r1"

DEPENDS += "gtk+ gconf libxtst"

EXTRA_OECONF += "\
                --disable-alsa \
                --disable-dssi \
                --disable-qt4-peer \
                --disable-plugin \
                --enable-gconf-peer \
                --enable-gtk-peer \
                --enable-local-sockets \
                --with-vm=java \
               "

