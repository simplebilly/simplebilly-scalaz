package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BilanzItem._

case class BilanzItem (
  amount: String,
konto: String,
name: String)

object BilanzItem {
  import DateTimeCodecs._

  implicit val BilanzItemCodecJson: CodecJson[BilanzItem] = CodecJson.derive[BilanzItem]
  implicit val BilanzItemDecoder: EntityDecoder[BilanzItem] = jsonOf[BilanzItem]
  implicit val BilanzItemEncoder: EntityEncoder[BilanzItem] = jsonEncoderOf[BilanzItem]
}
