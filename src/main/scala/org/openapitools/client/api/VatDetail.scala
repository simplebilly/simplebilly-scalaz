package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VatDetail._

case class VatDetail (
  count: Long,
netAmount: String,
taxAmount: String,
taxRate: String)

object VatDetail {
  import DateTimeCodecs._

  implicit val VatDetailCodecJson: CodecJson[VatDetail] = CodecJson.derive[VatDetail]
  implicit val VatDetailDecoder: EntityDecoder[VatDetail] = jsonOf[VatDetail]
  implicit val VatDetailEncoder: EntityEncoder[VatDetail] = jsonEncoderOf[VatDetail]
}
