require busybox_1.1x.inc
PR = "${INC_PR}.1"

SRC_URI += " \
	file://busybox-1.18.1-hush.patch \
	file://busybox-1.18.1-cpio.patch \
	file://busybox-1.18.1-bzip2.patch \
	"

SRC_URI[md5sum] = "f15fe752d8b7012aa5e59f83b88ccb1c"
SRC_URI[sha256sum] = "33eb25ea7b20c727c3af769256b21408a1ac1f927ff9f89a1f1e3767c18c9967"

