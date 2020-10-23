package myencode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;

import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Author duronggang
 * @Date 2020/10/22
 * @projectName wlk2.0
 * @description：
 */
class DuMultiFormatWriter implements Writer {

    @Override
    public BitMatrix encode(String contents,
                            BarcodeFormat format,
                            int width,
                            int height) throws WriterException {
        return encode(contents, format, width, height, null);
    }


    @Override
    public BitMatrix encode(String contents,
                            BarcodeFormat format,
                            int width, int height,
                            Map<EncodeHintType, ?> hints) throws WriterException {

        Writer writer;
        switch (format) {
            case EAN_8:
                writer = new EAN8Writer();
                break;
            case UPC_E:
                writer = new UPCEWriter();
                break;
            case EAN_13:
                writer = new EAN13Writer();
                break;
            case UPC_A:
                writer = new UPCAWriter();
                break;
            case QR_CODE:
                writer = new DuQRCodeWriter();
                break;
            case CODE_39:
                writer = new Code39Writer();
                break;
            case CODE_93:
                writer = new Code93Writer();
                break;
            case CODE_128:
                writer = new Code128Writer();
                break;
            case ITF:
                writer = new ITFWriter();
                break;
            case PDF_417:
                writer = new PDF417Writer();
                break;
            case CODABAR:
                writer = new CodaBarWriter();
                break;
            case DATA_MATRIX:
                writer = new DataMatrixWriter();
                break;
            case AZTEC:
                writer = new AztecWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + format);
        }
        return writer.encode(contents, format, width, height, hints);
    }
}
