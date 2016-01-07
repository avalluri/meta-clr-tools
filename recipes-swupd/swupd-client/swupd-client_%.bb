LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=04d0b48662817042d80393e7511fa41b \
                    file://bsdiff/LICENSE;md5=0dbe7a50f028269750631fcbded3846a"

PV = "5250"

SRC_URI = " \
  http://kojiclear.jf.intel.com/cgit/projects/swupd-client/snapshot/swupd-client-${PV}.tar.gz \
  file://Fix-build-failure-on-Yocto.patch \
  "
SRC_URI[md5sum] = "fd89af18857a7f5b7281baac9f1824db"
SRC_URI[sha256sum] = "9e33ced6dbb78659d4ab2d5e5f1f3d39ba60e1ef4d4ec603da594a54d986cea6"

DEPENDS = "zlib curl openssl xz"

PACKAGECONFIG[bzip2] = "--enable-bzip2,--disable-bzip2,bzip2"

inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} += " \
  ${datadir}/clear/update-ca/ \
"
