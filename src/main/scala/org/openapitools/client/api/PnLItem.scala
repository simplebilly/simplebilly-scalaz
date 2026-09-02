package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PnLItem._

case class PnLItem (
  account: String,
accountName: String,
amount: String)

object PnLItem {
  import DateTimeCodecs._

  implicit val PnLItemCodecJson: CodecJson[PnLItem] = CodecJson.derive[PnLItem]
  implicit val PnLItemDecoder: EntityDecoder[PnLItem] = jsonOf[PnLItem]
  implicit val PnLItemEncoder: EntityEncoder[PnLItem] = jsonEncoderOf[PnLItem]
}
