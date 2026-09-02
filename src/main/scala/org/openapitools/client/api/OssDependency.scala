package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OssDependency._

case class OssDependency (
  dependencyType: String,
license: Option[String],
name: String,
version: String)

object OssDependency {
  import DateTimeCodecs._

  implicit val OssDependencyCodecJson: CodecJson[OssDependency] = CodecJson.derive[OssDependency]
  implicit val OssDependencyDecoder: EntityDecoder[OssDependency] = jsonOf[OssDependency]
  implicit val OssDependencyEncoder: EntityEncoder[OssDependency] = jsonEncoderOf[OssDependency]
}
