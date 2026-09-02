package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GuVItem._

case class GuVItem (
  account: String,
amount: String,
name: String)

object GuVItem {
  import DateTimeCodecs._

  implicit val GuVItemCodecJson: CodecJson[GuVItem] = CodecJson.derive[GuVItem]
  implicit val GuVItemDecoder: EntityDecoder[GuVItem] = jsonOf[GuVItem]
  implicit val GuVItemEncoder: EntityEncoder[GuVItem] = jsonEncoderOf[GuVItem]
}
