package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteType._

case class InstituteType (
  
object InstituteType {
  import DateTimeCodecs._

  implicit val InstituteTypeCodecJson: CodecJson[InstituteType] = CodecJson.derive[InstituteType]
  implicit val InstituteTypeDecoder: EntityDecoder[InstituteType] = jsonOf[InstituteType]
  implicit val InstituteTypeEncoder: EntityEncoder[InstituteType] = jsonEncoderOf[InstituteType]
}
