package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PackingQueue._

case class PackingQueue (
  items: List[PackingQueueItem],
page: Integer,
pageSize: Integer,
totalCount: Long)

object PackingQueue {
  import DateTimeCodecs._

  implicit val PackingQueueCodecJson: CodecJson[PackingQueue] = CodecJson.derive[PackingQueue]
  implicit val PackingQueueDecoder: EntityDecoder[PackingQueue] = jsonOf[PackingQueue]
  implicit val PackingQueueEncoder: EntityEncoder[PackingQueue] = jsonEncoderOf[PackingQueue]
}
