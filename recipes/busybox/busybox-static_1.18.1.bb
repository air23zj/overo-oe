require busybox_${PV}.bb

FILESPATHPKG =. "busybox-${PV}:"
S = "${WORKDIR}/busybox-${PV}"

do_configure_append() {
	sed -i -e '/CONFIG_STATIC/d' .config
	echo "CONFIG_STATIC=y" >>.config
}

