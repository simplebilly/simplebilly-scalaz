package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmployeeStatus._

case class EmployeeStatus (
  
object EmployeeStatus {
  import DateTimeCodecs._

  implicit val EmployeeStatusCodecJson: CodecJson[EmployeeStatus] = CodecJson.derive[EmployeeStatus]
  implicit val EmployeeStatusDecoder: EntityDecoder[EmployeeStatus] = jsonOf[EmployeeStatus]
  implicit val EmployeeStatusEncoder: EntityEncoder[EmployeeStatus] = jsonEncoderOf[EmployeeStatus]
}
