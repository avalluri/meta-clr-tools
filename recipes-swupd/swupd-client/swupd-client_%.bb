LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=04d0b48662817042d80393e7511fa41b \
                    file://bsdiff/LICENSE;md5=0dbe7a50f028269750631fcbded3846a"

PV = "5700"

SRC_URI = " \
  http://kojiclear.jf.intel.com/cgit/projects/swupd-client/snapshot/swupd-client-${PV}.tar.gz \
  file://Fix-build-failure-on-Yocto.patch \
  "
SRC_URI[md5sum] = "58671adf559dd18620f11caf4ccf83dd"
SRC_URI[sha256sum] = "09a70a423d10a6bf71f8675b7430c29a56f41f93493331c9ae515011713c229b"


DEPENDS = "zlib curl openssl xz"

PACKAGECONFIG[bzip2] = "--enable-bzip2,--disable-bzip2,bzip2"

inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} += " \
  ${datadir}/clear/update-ca/ \
  ${base_libdir}/systemd/system/ \
"
