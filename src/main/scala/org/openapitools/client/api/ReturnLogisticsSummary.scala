package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReturnLogisticsSummary._

case class ReturnLogisticsSummary (
  /* Number of return orders per status. */
  byStatus: AnyType,
/* Per-warehouse aggregation. */
  byWarehouse: List[ReturnWarehouseSummary],
/* Sum of `restock: true` line-item quantities. */
  itemsRestocked: Long,
/* Sum of `restock: false` line-item quantities (scrapped/disposed). */
  itemsScrapped: Long,
/* Sum of all line-item quantities across returns. */
  totalItems: Long,
/* Total number of return orders (excluding soft-deleted). */
  totalReturns: Long)

object ReturnLogisticsSummary {
  import DateTimeCodecs._

  implicit val ReturnLogisticsSummaryCodecJson: CodecJson[ReturnLogisticsSummary] = CodecJson.derive[ReturnLogisticsSummary]
  implicit val ReturnLogisticsSummaryDecoder: EntityDecoder[ReturnLogisticsSummary] = jsonOf[ReturnLogisticsSummary]
  implicit val ReturnLogisticsSummaryEncoder: EntityEncoder[ReturnLogisticsSummary] = jsonEncoderOf[ReturnLogisticsSummary]
}
