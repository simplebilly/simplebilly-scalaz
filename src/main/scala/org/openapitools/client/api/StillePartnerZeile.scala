package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StillePartnerZeile._

case class StillePartnerZeile (
  auseinandersetzungsguthaben: String,
gewinnanteil: String,
gewinnvortrag: String,
hinweis: Option[String],
instrumentType: String,
kest: String,
name: String,
verlustVerrechnungskonto: String,
verlustanteil: String)

object StillePartnerZeile {
  import DateTimeCodecs._

  implicit val StillePartnerZeileCodecJson: CodecJson[StillePartnerZeile] = CodecJson.derive[StillePartnerZeile]
  implicit val StillePartnerZeileDecoder: EntityDecoder[StillePartnerZeile] = jsonOf[StillePartnerZeile]
  implicit val StillePartnerZeileEncoder: EntityEncoder[StillePartnerZeile] = jsonEncoderOf[StillePartnerZeile]
}
