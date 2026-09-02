package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CompanyType._

case class CompanyType (
  
object CompanyType {
  import DateTimeCodecs._

  implicit val CompanyTypeCodecJson: CodecJson[CompanyType] = CodecJson.derive[CompanyType]
  implicit val CompanyTypeDecoder: EntityDecoder[CompanyType] = jsonOf[CompanyType]
  implicit val CompanyTypeEncoder: EntityEncoder[CompanyType] = jsonEncoderOf[CompanyType]
}
