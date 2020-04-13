#
# An example of a hacker image
#

# First include a base image to base things off
# require recipes-core/images/core-image-minimal.bb
require recipes-graphics/images/core-image-weston.bb
require recipes-filesystems/images/meta-filesystems-image.bb

DESCRIPTION = "A master image to be deployed on a target useful for testing other images"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-core-buildessential \
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

# Dev
IMAGE_INSTALL += "gcc"
IMAGE_INSTALL += "git"
IMAGE_INSTALL += "git-perltools"
IMAGE_INSTALL += "vim"
IMAGE_INSTALL += "cmake"
IMAGE_INSTALL += "rsync"

# Game
# IMAGE_INSTALL += "vc-graphics"
# IMAGE_INSTALL += "libsdl2-dev"
# IMAGE_INSTALL += "glfw"
IMAGE_INSTALL += "glm-dev"
IMAGE_INSTALL += "libgl-mesa-dev"
# IMAGE_INSTALL += "libegl-mesa-dev"
# IMAGE_INSTALL += "libgles1-mesa-dev"
# IMAGE_INSTALL += "libgles2-mesa-dev"
# IMAGE_INSTALL += "libgles3-mesa-dev"
# IMAGE_INSTALL += "libglapi-dev"
# IMAGE_INSTALL += "directfb-dev"
# IMAGE_INSTALL += "directfb-examples-dev"

IMAGE_INSTALL += "libinput"
IMAGE_INSTALL += "wayland"
IMAGE_INSTALL += "wayland-protocols"
IMAGE_INSTALL += "weston"
IMAGE_INSTALL += "weston-init"

# Set as depends in other receipe
# IMAGE_INSTALL += "bluez5"

# Hacket need more memory
QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'

# Ensure there's enough space to do a core-image-hacker build
# IMAGE_ROOTFS_EXTRA_SPACE = "41943040"

# Do a quiet boot with limited console messages
APPEND += "rootfstype=ext4 quiet"
