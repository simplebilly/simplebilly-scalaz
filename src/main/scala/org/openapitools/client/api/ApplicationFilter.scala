package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ApplicationFilter._

case class ApplicationFilter (
  page: Option[Integer],
pageSize: Option[Integer],
postingId: Option[UUID],
status: Option[String])

object ApplicationFilter {
  import DateTimeCodecs._

  implicit val ApplicationFilterCodecJson: CodecJson[ApplicationFilter] = CodecJson.derive[ApplicationFilter]
  implicit val ApplicationFilterDecoder: EntityDecoder[ApplicationFilter] = jsonOf[ApplicationFilter]
  implicit val ApplicationFilterEncoder: EntityEncoder[ApplicationFilter] = jsonEncoderOf[ApplicationFilter]
}
