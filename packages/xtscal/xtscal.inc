DESCRIPTION = "Touchscreen calibration utility"
SECTION = "x11/base"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxft libxrandr xcalibrate"

SRC_URI = "${GPE_MIRROR}/xtscal-${PV}.tar.bz2"

inherit autotools