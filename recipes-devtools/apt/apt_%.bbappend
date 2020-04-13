# Example use of configuration fragments for apt, which uses the same
# mechanism as the linux-yocto kernel recipe.
#
# The entries here will override any entries in the base apt recipe
#
# More details can be found in the Kernel Dev Manual
# http://www.yoctoproject.org/docs/current/kernel-dev/kernel-dev.html#changing-the-configuration
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	    file://hacker.list \
           "

# S = "${WORKDIR}/apt-${PV}"

do_install_append() {
    install -d ${D}${sysconfdir}/apt/sources.list.d
    install -m 0644 ${WORKDIR}/hacker.list ${D}${sysconfdir}/apt/sources.list.d/hacker.list
}
