# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; if that is correct you should separate
# these in the LICENSE value using & if the multiple licenses all apply, or | if there
# is a choice between the multiple licenses. If in doubt, check the accompanying
# documentation to determine which situation is applicable.
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=04d0b48662817042d80393e7511fa41b \
                    file://bsdiff/LICENSE;md5=0dbe7a50f028269750631fcbded3846a"

PV = "5250"

SRC_URI = "http://kojiclear.jf.intel.com/cgit/projects/swupd-client/snapshot/swupd-client-${PV}.tar.gz"
SRC_URI[md5sum] = "fd89af18857a7f5b7281baac9f1824db"
SRC_URI[sha256sum] = "9e33ced6dbb78659d4ab2d5e5f1f3d39ba60e1ef4d4ec603da594a54d986cea6"

DEPENDS = "bzip2 zlib curl xz"
RDEPENDS_${PN} = "openssl xz"
# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} += " \
  ${datadir}/clear/update-ca/ \
"
