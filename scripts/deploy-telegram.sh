#!/bin/bash

set -e
BUILD_SHA_SHORT=$(git rev-parse --short ${BUILD_SHA})

if [[ -e GRDP-user-ci-${BUILD_SHA_SHORT}.apk ]]
then
    curl -F chat_id="-1001454468239" -F document=@"GRDP-user-ci-${BUILD_SHA_SHORT}.apk" https://api.telegram.org/bot$BOT_TOKEN/sendDocument
    curl -F chat_id="-1001454468239" -F sticker="CAADBQADPQADTBCSGr060PvRNzIFAg" https://api.telegram.org/bot$BOT_TOKEN/sendSticker
else
    curl -F chat_id="-1001454468239" -F text="Build failed!" https://api.telegram.org/bot$BOT_TOKEN/sendMessage
fi