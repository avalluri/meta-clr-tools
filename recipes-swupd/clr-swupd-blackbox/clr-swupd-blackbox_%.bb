LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SUMMARY = "Module to get hashes for update"

PV="5700"
SRC_URI = " \
  http://kojiclear.jf.intel.com/cgit/projects/clr-swupd-blackbox/snapshot/clr-swupd-blackbox-${PV}.tar.gz \
  file://0001-Enhancements-to-blackbox.patch \
"

SRC_URI[md5sum] = "ae6de24b3c4e04b317f257a62f4aeaf4"
SRC_URI[sha256sum] = "b4901db76a47fd3815c94bc25a885252c639273f31a9e000793c2d19f8860500"


DEPENDS += "swupd-client"
RDEPENDS_${PN} += "python3-core python3-modules python3-misc curl bash"
CFLAGS="-lpython${PYTHON_BASEVERSION}${PYTHON_ABI}"

inherit distutils3 systemd

do_install_append () {
  install -d "${D}${systemd_unitdir}/user"
  install -m 0644 "${S}/auto_swupd_bb.service" "${D}${systemd_unitdir}/user"
  install -d "${D}/usr/local/bin/"
  install -m 0744 "${S}/auto_swupd_bb.sh" "${D}/usr/local/bin/"
  install -m 0744 "${S}/swupd_bb.py" "${D}/usr/local/bin/"
}

FILES_${PN} += " \
  /usr/local/bin/ \
  ${systemd_unitdir}/user \
"

