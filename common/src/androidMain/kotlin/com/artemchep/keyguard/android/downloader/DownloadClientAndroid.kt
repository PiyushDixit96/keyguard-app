package com.artemchep.keyguard.android.downloader

import android.app.Application
import android.content.Context
import com.artemchep.keyguard.common.service.crypto.CryptoGenerator
import com.artemchep.keyguard.common.service.crypto.FileEncryptor
import com.artemchep.keyguard.common.usecase.WindowCoroutineScope
import com.artemchep.keyguard.copy.download.DownloadClientJvm
import okhttp3.OkHttpClient
import org.kodein.di.DirectDI
import org.kodein.di.instance

class DownloadClientAndroid(
    private val context: Context,
    cryptoGenerator: CryptoGenerator,
    windowCoroutineScope: WindowCoroutineScope,
    okHttpClient: OkHttpClient,
    fileEncryptor: FileEncryptor,
) : DownloadClientJvm(
    cacheDirProvider = {
        context.cacheDir
    },
    cryptoGenerator = cryptoGenerator,
    windowCoroutineScope = windowCoroutineScope,
    okHttpClient = okHttpClient,
    fileEncryptor = fileEncryptor,
) {
    constructor(
        directDI: DirectDI,
    ) : this(
        context = directDI.instance<Application>(),
        cryptoGenerator = directDI.instance(),
        windowCoroutineScope = directDI.instance(),
        okHttpClient = directDI.instance(),
        fileEncryptor = directDI.instance(),
    )
}
