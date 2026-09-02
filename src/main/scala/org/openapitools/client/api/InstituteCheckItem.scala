package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteCheckItem._

case class InstituteCheckItem (
  exists: Boolean,
name: String,
source: String)

object InstituteCheckItem {
  import DateTimeCodecs._

  implicit val InstituteCheckItemCodecJson: CodecJson[InstituteCheckItem] = CodecJson.derive[InstituteCheckItem]
  implicit val InstituteCheckItemDecoder: EntityDecoder[InstituteCheckItem] = jsonOf[InstituteCheckItem]
  implicit val InstituteCheckItemEncoder: EntityEncoder[InstituteCheckItem] = jsonEncoderOf[InstituteCheckItem]
}
