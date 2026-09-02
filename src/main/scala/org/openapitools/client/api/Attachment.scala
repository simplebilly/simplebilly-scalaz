package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import Attachment._

case class Attachment (
  /* Contact this attachment belongs to (per-contact DMS). References the contact entity. */
  contactId: Option[String],
fileName: String,
fileSize: Option[Long],
mimeType: Option[String],
/* Raw text extracted by client-side OCR (tesseract.js), if run. */
  ocrText: Option[String],
originalName: String,
pdfaPath: Option[String],
sha256Hash: Option[String],
uploadedBy: Option[UUID])

object Attachment {
  import DateTimeCodecs._

  implicit val AttachmentCodecJson: CodecJson[Attachment] = CodecJson.derive[Attachment]
  implicit val AttachmentDecoder: EntityDecoder[Attachment] = jsonOf[Attachment]
  implicit val AttachmentEncoder: EntityEncoder[Attachment] = jsonEncoderOf[Attachment]
}
