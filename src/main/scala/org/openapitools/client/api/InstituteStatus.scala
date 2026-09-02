package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteStatus._

case class InstituteStatus (
  checklist: List[InstituteCheckItem],
deadlines: InstituteDeadlines,
instituteType: String,
kapitalmarktorientiert: Boolean)

object InstituteStatus {
  import DateTimeCodecs._

  implicit val InstituteStatusCodecJson: CodecJson[InstituteStatus] = CodecJson.derive[InstituteStatus]
  implicit val InstituteStatusDecoder: EntityDecoder[InstituteStatus] = jsonOf[InstituteStatus]
  implicit val InstituteStatusEncoder: EntityEncoder[InstituteStatus] = jsonEncoderOf[InstituteStatus]
}
