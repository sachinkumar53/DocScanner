package com.sachin.app.docscanner2

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import com.zynksoftware.documentscanner.ScanActivity
import com.zynksoftware.documentscanner.model.DocumentScannerErrorModel
import com.zynksoftware.documentscanner.model.ScannerResults

class DocScanActivity : ScanActivity() {
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_scan)
        imageView = findViewById(R.id.scanImageView)
        addFragmentContentLayout()
    }


    override fun onSuccess(scannerResults: ScannerResults) {
        try {
            imageView.setImageURI(Uri.fromFile(scannerResults.croppedImageFile))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onError(error: DocumentScannerErrorModel) {

    }

    override fun onClose() {
        finish()
    }
}