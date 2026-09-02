package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import AttachmentVersion._

case class AttachmentVersion (
  /* Parent attachment whose history this row records. */
  attachmentId: UUID,
/* Storage key of this version's bytes. */
  fileName: String,
fileSize: Option[Long],
mimeType: Option[String],
originalName: Option[String],
sha256Hash: Option[String],
uploadedBy: Option[UUID],
/* 1-based; ascending per attachment in upload order. */
  versionNumber: Integer)

object AttachmentVersion {
  import DateTimeCodecs._

  implicit val AttachmentVersionCodecJson: CodecJson[AttachmentVersion] = CodecJson.derive[AttachmentVersion]
  implicit val AttachmentVersionDecoder: EntityDecoder[AttachmentVersion] = jsonOf[AttachmentVersion]
  implicit val AttachmentVersionEncoder: EntityEncoder[AttachmentVersion] = jsonEncoderOf[AttachmentVersion]
}
