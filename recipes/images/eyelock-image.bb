# eyelock image for gumstix overo

inherit image

DEPENDS = "task-base"

IMAGE_EXTRA_INSTALL ?= " \
  opencv-dev \
  opencv-samples \
  task-native-sdk \
  gdbserver \
  alsa-utils-aplay \
 "

BASE_INSTALL = " \
  task-base-extended \
 "

FIRMWARE_INSTALL = " \
  libertas-sd-firmware \
 "

TOOLS_INSTALL = " \
  bzip2 \
  devmem2 \
  openssh-misc \
  openssh-scp \
  openssh-ssh \
  task-proper-tools \
 "

IMAGE_INSTALL += " \
  ${BASE_INSTALL} \
  ${FIRMWARE_INSTALL} \
  ${IMAGE_EXTRA_INSTALL} \
  ${TOOLS_INSTALL} \
 "

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

export IMAGE_BASENAME = "eyelock-image"
IMAGE_LINGUAS = ""

am
