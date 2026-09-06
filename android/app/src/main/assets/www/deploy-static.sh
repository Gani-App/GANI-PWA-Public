#!/bin/sh
set -eu
TARGET="${1:-}"
[ -n "$TARGET" ] || { echo "Usage: ./deploy-static.sh /absolute/web/root"; exit 2; }
case "$TARGET" in /*) ;; *) echo "Target must be an absolute path"; exit 2;; esac
mkdir -p "$TARGET"
cp index.html install.html manifest.webmanifest sw.js icon-192.png icon-512.png icon-maskable-512.png "$TARGET"/
echo "GANI static files copied to: $TARGET"
echo "No web server was restarted and no TLS/domain was changed."
