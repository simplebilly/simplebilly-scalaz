package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import GenerateCountRequest._

case class GenerateCountRequest (
  notes: Option[String],
productIds: Option[List[UUID]],
warehouseId: String)

object GenerateCountRequest {
  import DateTimeCodecs._

  implicit val GenerateCountRequestCodecJson: CodecJson[GenerateCountRequest] = CodecJson.derive[GenerateCountRequest]
  implicit val GenerateCountRequestDecoder: EntityDecoder[GenerateCountRequest] = jsonOf[GenerateCountRequest]
  implicit val GenerateCountRequestEncoder: EntityEncoder[GenerateCountRequest] = jsonEncoderOf[GenerateCountRequest]
}
