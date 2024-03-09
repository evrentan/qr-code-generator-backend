package evrentan.qrcodegenerator.qrcodegeneratorbackend.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.dto.GenerateQrCodeRequest;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.exception.QrCodeTextValidationException;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.message.ExceptionMessages;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.service.QrCodeService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

/**
 * QrCode Service Implementation for QrCode Service Layer.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {

  private static final Integer QR_CODE_SIZE = 200;
  private static final String QR_CODE_BACKGROUND_COLOR = "ffffff";
  private static final String QR_CODE_FILE_FORMAT = "png";

  /**
   * Generate QR Code according to the given request.
   *
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return String which corresponds to generated QR Code in base64 String.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public String generateQrCodeString(GenerateQrCodeRequest qrCodeGenerateRequest) {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    this.completeGenerateQrCodeRequest(qrCodeGenerateRequest);

    this.generateByteArrayOutputStream(byteArrayOutputStream, qrCodeGenerateRequest);

    return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
  }

  /**
   * Generate QR Code according to the given request.
   *
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return byte[] which corresponds to generated QR Code.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public byte[] generateQrCodeByteArray(GenerateQrCodeRequest qrCodeGenerateRequest) {
    this.validateQrCodeText(qrCodeGenerateRequest.getQrCodeText());

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    this.completeGenerateQrCodeRequest(qrCodeGenerateRequest);

    this.generateByteArrayOutputStream(byteArrayOutputStream, qrCodeGenerateRequest);

    return byteArrayOutputStream.toByteArray();
  }

  /**
   * Complete the given request with default values for size and background color if they are not set in the request.
   *
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  private void completeGenerateQrCodeRequest(GenerateQrCodeRequest qrCodeGenerateRequest) {
    this.validateQrCodeText(qrCodeGenerateRequest.getQrCodeText());

    if (Objects.isNull(qrCodeGenerateRequest.getSize()))
      qrCodeGenerateRequest.setSize(QR_CODE_SIZE);

    if (Objects.isNull(qrCodeGenerateRequest.getBackGroundColor()))
      qrCodeGenerateRequest.setBackGroundColor(QR_CODE_BACKGROUND_COLOR);
  }

  /**
   * Generate Byte Array Output Stream according to the given request
   *
   * @param byteArrayOutputStream Byte Array Output Stream which is used to generate QR Code.
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  private void generateByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream, GenerateQrCodeRequest qrCodeGenerateRequest) {
    QRCodeWriter qrCodeWriter = new QRCodeWriter();

    try {
      BitMatrix bitMatrix =
          qrCodeWriter.encode(qrCodeGenerateRequest.getQrCodeText()
              , BarcodeFormat.QR_CODE
              , qrCodeGenerateRequest.getSize(), qrCodeGenerateRequest.getSize());

      BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

      ImageIO.write(bufferedImage, QR_CODE_FILE_FORMAT, byteArrayOutputStream);
    } catch (WriterException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void validateQrCodeText(String qrCodeText) {
    if (qrCodeText.isBlank()) {
      throw new QrCodeTextValidationException(ExceptionMessages.QR_CODE_TEXT_VALIDATION_EXCEPTION);
    }
  }
}
