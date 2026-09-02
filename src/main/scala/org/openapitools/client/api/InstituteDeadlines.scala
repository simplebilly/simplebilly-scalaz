package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteDeadlines._

case class InstituteDeadlines (
  /* HGB § 340k/§ 341k: Abschlussprüfung (5 Monate). */
  abschlusspruefungMonths: Option[Integer],
/* KWG § 26: Jahresabschluss an die BaFin (3 Monate, nur KWG-Institute). */
  jahresabschlussBafinMonths: Option[Integer],
/* HGB § 325 Abs. 4: Offenlegung (4 kapitalmarktorientiert / 12 sonst). */
  offenlegungMonths: Integer)

object InstituteDeadlines {
  import DateTimeCodecs._

  implicit val InstituteDeadlinesCodecJson: CodecJson[InstituteDeadlines] = CodecJson.derive[InstituteDeadlines]
  implicit val InstituteDeadlinesDecoder: EntityDecoder[InstituteDeadlines] = jsonOf[InstituteDeadlines]
  implicit val InstituteDeadlinesEncoder: EntityEncoder[InstituteDeadlines] = jsonEncoderOf[InstituteDeadlines]
}
