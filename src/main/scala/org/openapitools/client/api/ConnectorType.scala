package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ConnectorType._

case class ConnectorType (
  
object ConnectorType {
  import DateTimeCodecs._

  implicit val ConnectorTypeCodecJson: CodecJson[ConnectorType] = CodecJson.derive[ConnectorType]
  implicit val ConnectorTypeDecoder: EntityDecoder[ConnectorType] = jsonOf[ConnectorType]
  implicit val ConnectorTypeEncoder: EntityEncoder[ConnectorType] = jsonEncoderOf[ConnectorType]
}
