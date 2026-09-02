package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteProfile._

case class InstituteProfile (
  /* Institutsart: \"kein\" | \"kreditinstitut\" | \"finanzdienstleistungsinstitut\" | \"finanzunternehmen\" | \"versicherung\". */
  instituteType: Option[InstituteType],
/* Kapitalmarktorientierung (§ 325 Abs. 4 HGB): Offenlegungsfrist 4 statt 12 Monate. */
  kapitalmarktorientiert: Option[Boolean])

object InstituteProfile {
  import DateTimeCodecs._

  implicit val InstituteProfileCodecJson: CodecJson[InstituteProfile] = CodecJson.derive[InstituteProfile]
  implicit val InstituteProfileDecoder: EntityDecoder[InstituteProfile] = jsonOf[InstituteProfile]
  implicit val InstituteProfileEncoder: EntityEncoder[InstituteProfile] = jsonEncoderOf[InstituteProfile]
}
