package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlatformInfo._

case class PlatformInfo (
  author: String,
changelog: List[ChangelogEntry],
configFieldNames: List[String],
configFields: List[ConfigFieldInfo],
displayName: String,
platform: String,
pricing: PluginPricing,
supportedEntities: List[String],
supportsExport: Boolean,
supportsImport: Boolean,
supportsOauth: Boolean,
version: String)

object PlatformInfo {
  import DateTimeCodecs._

  implicit val PlatformInfoCodecJson: CodecJson[PlatformInfo] = CodecJson.derive[PlatformInfo]
  implicit val PlatformInfoDecoder: EntityDecoder[PlatformInfo] = jsonOf[PlatformInfo]
  implicit val PlatformInfoEncoder: EntityEncoder[PlatformInfo] = jsonEncoderOf[PlatformInfo]
}
