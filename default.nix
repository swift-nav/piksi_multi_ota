# Copyright (C) 2019-2023 Swift Navigation Inc.
# Contact: https://support.swiftnav.com
#
# This source is subject to the license found in the file 'LICENSE' which must
# be be distributed together with this source. All other rights reserved.
# 
# THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
# WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR PURPOSE.

with import <nixpkgs> {};

stdenv.mkDerivation rec {
  name = "piksi_ota";
  env = buildEnv { name = name; paths = buildInputs; };
  buildInputs = [
    maven
    jdk
    jre
  ];
}
