package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import AttachmentCreate._

case class AttachmentCreate (
  /* Contact this attachment belongs to (per-contact DMS). References the contact entity. */
  contactId: Option[String],
fileName: String,
fileSize: Option[Long],
mimeType: Option[String],
originalName: String,
pdfaPath: Option[String],
sha256Hash: Option[String],
uploadedBy: Option[UUID])

object AttachmentCreate {
  import DateTimeCodecs._

  implicit val AttachmentCreateCodecJson: CodecJson[AttachmentCreate] = CodecJson.derive[AttachmentCreate]
  implicit val AttachmentCreateDecoder: EntityDecoder[AttachmentCreate] = jsonOf[AttachmentCreate]
  implicit val AttachmentCreateEncoder: EntityEncoder[AttachmentCreate] = jsonEncoderOf[AttachmentCreate]
}
