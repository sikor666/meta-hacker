#
# An example of a hacker image
#

# First include a base image to base things off
require recipes-core/images/core-image-minimal.bb
require recipes-filesystems/images/meta-filesystems-image.bb

DESCRIPTION = "A master image to be deployed on a target useful for testing other images"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-core-buildessential \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    "

# Now add the hacker packages we want to install
IMAGE_INSTALL += "apt"
IMAGE_INSTALL += "gnupg"
IMAGE_INSTALL += "coreutils"
IMAGE_INSTALL += "util-linux"

IMAGE_INSTALL += "e2fsprogs-resize2fs"
IMAGE_INSTALL += "e2fsprogs-mke2fs"
IMAGE_INSTALL += "ntfs-3g"

IMAGE_INSTALL += "base-files"
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "bash-completion"

IMAGE_INSTALL += "gcc"
IMAGE_INSTALL += "git"
IMAGE_INSTALL += "vim"

# Set as depends in other receipe
# IMAGE_INSTALL += "bluez5"

# Hacket need more memory
QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'

# Ensure there's enough space to do a core-image-hacker build
# IMAGE_ROOTFS_EXTRA_SPACE = "41943040"

# Do a quiet boot with limited console messages
APPEND += "rootfstype=ext4 quiet"
