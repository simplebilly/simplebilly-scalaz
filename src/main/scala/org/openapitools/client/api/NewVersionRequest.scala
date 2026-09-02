package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import NewVersionRequest._

case class NewVersionRequest (
  /* Storage key of the already-uploaded bytes. */
  fileName: String,
fileSize: Option[Long],
mimeType: Option[String],
originalName: Option[String],
sha256Hash: Option[String])

object NewVersionRequest {
  import DateTimeCodecs._

  implicit val NewVersionRequestCodecJson: CodecJson[NewVersionRequest] = CodecJson.derive[NewVersionRequest]
  implicit val NewVersionRequestDecoder: EntityDecoder[NewVersionRequest] = jsonOf[NewVersionRequest]
  implicit val NewVersionRequestEncoder: EntityEncoder[NewVersionRequest] = jsonEncoderOf[NewVersionRequest]
}
