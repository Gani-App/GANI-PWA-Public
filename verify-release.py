#!/usr/bin/env python3
from pathlib import Path
import hashlib, sys
root=Path(__file__).resolve().parent
required=["index.html","install.html","manifest.webmanifest","sw.js",
          "icon-192.png","icon-512.png","icon-maskable-512.png","release.json",
          "platform-v27.css","platform-v27.js"]
missing=[x for x in required if not (root/x).is_file()]
if missing:
    print("FAIL missing:", ", ".join(missing)); sys.exit(1)
print("PASS required files")
for x in required:
    p=root/x
    print(hashlib.sha256(p.read_bytes()).hexdigest(), x)
print("STATIC_RELEASE_ACCEPTANCE=PASS")
