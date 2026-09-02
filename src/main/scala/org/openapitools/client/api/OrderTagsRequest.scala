package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OrderTagsRequest._

case class OrderTagsRequest (
  tags: List[String])

object OrderTagsRequest {
  import DateTimeCodecs._

  implicit val OrderTagsRequestCodecJson: CodecJson[OrderTagsRequest] = CodecJson.derive[OrderTagsRequest]
  implicit val OrderTagsRequestDecoder: EntityDecoder[OrderTagsRequest] = jsonOf[OrderTagsRequest]
  implicit val OrderTagsRequestEncoder: EntityEncoder[OrderTagsRequest] = jsonEncoderOf[OrderTagsRequest]
}
