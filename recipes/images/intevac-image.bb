# X11 factory image for omap3 -- trimmed down to fit nand

require omap3-console-image.bb

DEPENDS = task-sdk-native

IMAGE_LINGUAS = "en-us"

ANGSTROM_EXTRA_INSTALL ?= ""

SPLASH ?= "psplash"

APPS = " \
  gnome-mplayer \
  gpe-soundbite \
  midori \
  vnc \
  x11vnc \
  angstrom-x11vnc-xinit \
  xterm \
  vlc \
 "

E_CONFIG = " \
  e-wm-config-angstrom \
 "

E_MODULES = " \
  places \
 "

E17 = " \
  e-wm \
  e-wm-menu \
  e-wm-sysactions \
  ${E_CONFIG} \
  ${E_MODULES} \
 "

FONTS = " \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
 "  

SETTINGS = " \
#  networkmanager network-manager-applet networkmanager-openvpn \
#  gnome-bluetooth \
  gpe-conf \
#  gpe-package \
 "

XSERVER_BASE = " \
  ${XSERVER} \
  dbus-x11 \
  fontconfig-utils \
  gnome-icon-theme angstrom-gnome-icon-theme-enable \
  gnome-themes \
  gpe-theme-clearlooks \
  gtk-engine-clearlooks \
  gpe-dm \
  gpe-session-scripts \
  hicolor-icon-theme \
  mime-support \
  xauth \
  xdg-utils \
  xhost \
  xset \
  xlsfonts \
  xrefresh \
 "

IMAGE_INSTALL += " \
  ${APPS} \
  ${E17} \
  ${FONTS} \
  ${SETTINGS} \
  ${SPLASH} \
  ${XSERVER_BASE} \
 "

