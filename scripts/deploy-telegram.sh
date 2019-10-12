#!/usr/bin/env sh

BUILD_SHA_SHORT=$(git rev-parse --short ${BUILD_SHA})
curl -F chat_id="-1001454468239" -F document=@"GRDP-user-ci-${BUILD_SHA_SHORT}.apk" https://api.telegram.org/bot$BOT_TOKEN/sendDocument
curl -F chat_id="-1001454468239" -F sticker="CAADBQADPQADTBCSGr060PvRNzIFAg" https://api.telegram.org/bot$BOT_TOKEN/sendSticker
