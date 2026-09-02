package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SalesVolumeItem._

case class SalesVolumeItem (
  contactId: String,
contactType: String,
lastPurchaseDate: Option[String],
name: String,
totalInvoices: Integer,
totalRevenue: String)

object SalesVolumeItem {
  import DateTimeCodecs._

  implicit val SalesVolumeItemCodecJson: CodecJson[SalesVolumeItem] = CodecJson.derive[SalesVolumeItem]
  implicit val SalesVolumeItemDecoder: EntityDecoder[SalesVolumeItem] = jsonOf[SalesVolumeItem]
  implicit val SalesVolumeItemEncoder: EntityEncoder[SalesVolumeItem] = jsonEncoderOf[SalesVolumeItem]
}
