package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PublicReturnItem._

case class PublicReturnItem (
  name: Option[String],
productId: String,
quantity: Long,
reason: Option[String])

object PublicReturnItem {
  import DateTimeCodecs._

  implicit val PublicReturnItemCodecJson: CodecJson[PublicReturnItem] = CodecJson.derive[PublicReturnItem]
  implicit val PublicReturnItemDecoder: EntityDecoder[PublicReturnItem] = jsonOf[PublicReturnItem]
  implicit val PublicReturnItemEncoder: EntityEncoder[PublicReturnItem] = jsonEncoderOf[PublicReturnItem]
}
