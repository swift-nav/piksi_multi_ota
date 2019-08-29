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
