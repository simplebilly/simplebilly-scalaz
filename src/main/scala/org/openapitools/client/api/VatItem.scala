package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VatItem._

case class VatItem (
  netAmount: String,
taxAmount: String,
taxRate: String)

object VatItem {
  import DateTimeCodecs._

  implicit val VatItemCodecJson: CodecJson[VatItem] = CodecJson.derive[VatItem]
  implicit val VatItemDecoder: EntityDecoder[VatItem] = jsonOf[VatItem]
  implicit val VatItemEncoder: EntityEncoder[VatItem] = jsonEncoderOf[VatItem]
}
