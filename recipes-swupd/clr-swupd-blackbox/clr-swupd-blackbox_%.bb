LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SUMMARY = "Module to get hashes for update"

PV="5700"
SRC_URI = "http://kojiclear.jf.intel.com/cgit/projects/clr-swupd-blackbox/snapshot/clr-swupd-blackbox-${PV}.tar.gz"


DEPENDS += "swupd-client"
RDEPENDS_${PN} += "python3-core curl bash"
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

